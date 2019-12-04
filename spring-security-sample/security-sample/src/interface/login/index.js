import httpRequest from "@/components/http/index"

export const Login = (username,password) => httpRequest({
  method: 'post',
  url: '/auth/signIn',
  data: `username=${username}&password=${password}`,
  headers: {
    'X-Requested-With': 'XMLHttpRequest',
    'Content-Type': 'application/x-www-form-urlencoded'
  },
});
