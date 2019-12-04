import axios from "axios";
import { Notification } from "element-ui";

const httpRequest = axios.create();

// httpRequest.defaults.timeout = 3000;

httpRequest.interceptors.request.use(
  config => {
    config.timeout = 3000;
    return config;
  },
  error => {
    console.log(error);
    return Promise.reject(error);
  }
);

httpRequest.interceptors.response.use(
  resp => {
    return resp.data;
  },
  error => {
    if(error.response){
      let responseCode = error.response.status;
      switch (responseCode) {
        case 500:
          showError("服务器内部错误,请联系系统管理员");
          break;
        default:
          showError(`系统出错:${responseCode},  ${error.response.statusText}`);
      }
    }else if('ECONNABORTED'===error.code && error.message.indexOf("timeout")>=0){
      showError("请求超时,请稍后刷新重试");
    }
    return Promise.reject(error);
  }
);

export default httpRequest;

function showError(msg){
  Notification({
    title: "系统错误",
    message: msg,
    type: 'error'
  });
}
