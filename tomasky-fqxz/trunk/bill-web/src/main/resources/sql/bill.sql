/*==========================1.0版本迭代数据库变更sql====================================*/
-- 将已经退款的支付记录状态改为无需结算 --
update tomato_pay_record set is_balance = -1
where pay_type = '1' and is_balance = 0 and order_code in (
	select p.order_code
	from tomato_pay_record p
	where p.pay_type = '2'
);

-- 将短信充值记录状态改为无需结算 --
update tomato_pay_record set is_balance = -1
where pay_type = '1' and is_balance = 0 and product_code = 'msg_recharge';


SELECT p.id,m.check_out_at
FROM tomato_pay_record p
INNER JOIN tomato_consumer_main_order m ON m.ota_order_no = p.order_code
WHERE p.product_code IN ('new_xz_order', 'fqfx_order')

drop sequence if exists seq_tomato_inn_config_id cascade;
create sequence seq_tomato_inn_config_id start 100;
drop table if exists tomato_inn_config cascade;

/*==============================================================*/
/* Table: tomato_inn_config 客栈配置表                           */
/*==============================================================*/
create table tomato_inn_config (
   id                              integer                not null default nextval('seq_tomato_inn_config_id'::regclass),
   inn_id                          integer                null,
   poundage_ratio                  NUMERIC(5, 2)          null,
   created_at                      timestamp              null,
   updated_at                      timestamp              null,
   constraint pk_tomato_inn_config primary key (id)
)
WITH (
  OIDS=FALSE
);

COMMENT ON TABLE  "public"."tomato_inn_config" IS '客栈配置表';
COMMENT ON COLUMN "public"."tomato_inn_config"."id" IS 'PK';
COMMENT ON COLUMN "public"."tomato_inn_config"."poundage_ratio" IS '番茄代收的手续费率';

drop index if exists ix_tomato_inn_config_inn_id cascade;
create index ix_tomato_inn_config_inn_id on tomato_inn_config (inn_id);