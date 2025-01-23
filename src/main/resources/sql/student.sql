DROP TABLE IF EXISTS `student`;

create table student
(
    id          int auto_increment comment '学号'
        primary key,
    name        varchar(200)                       not null,
    create_time datetime default CURRENT_TIMESTAMP null,
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    gender      int      default 1                 null comment '性别'
)
    comment '测试';