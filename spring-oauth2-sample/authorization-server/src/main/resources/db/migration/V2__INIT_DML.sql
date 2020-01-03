create table `oauth_client_details` (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove tinyint(1)
);

INSERT INTO `oauth_client_details`(`client_id`,`client_secret`,`access_token_validity`,`scope`,`web_server_redirect_uri`,`autoapprove`)VALUES('client1','{bcrypt}$2a$10$goBwnQxOGETuhYHkLv2wbO9N/kE2LfgO7/a9EhuFSem0bKh8Yi7BK',600000000,'write','http://localhost:11001/',1);


INSERT INTO `users`(`username`,`password`,`enabled`)  VALUES ('zhangsan','{bcrypt}$2a$10$goBwnQxOGETuhYHkLv2wbO9N/kE2LfgO7/a9EhuFSem0bKh8Yi7BK',1);