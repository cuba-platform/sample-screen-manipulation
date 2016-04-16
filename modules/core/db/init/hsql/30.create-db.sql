insert into SAMPLE_CUSTOMER
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, EMAIL)
values ('405d5d7d-ed85-10e5-5e45-eeea2e574d18', '2016-04-11 09:34:55', 'admin', 1, '2016-04-11 09:34:55', null, null, null, 'Globex Corporation', 'info@globex.com');

insert into SAMPLE_CUSTOMER
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, EMAIL)
values ('d43d25fd-563e-0eb7-0766-0c01c27aae19', '2016-04-11 09:35:13', 'admin', 1, '2016-04-11 09:35:13', null, null, null, 'Sirius Cybernetics Corporation', 'info@sirius.com');

insert into SAMPLE_CUSTOMER
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, EMAIL)
values ('b01cfb8c-4797-6767-96cc-0b186e18de55', '2016-04-11 09:35:33', 'admin', 1, '2016-04-11 09:35:33', null, null, null, 'Initech', 'info@initech.com');

insert into SAMPLE_PRODUCT
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, CUSTOMER_ID)
values ('29bddf99-17eb-6b00-c03c-8f080ece5e76', '2016-04-16 12:20:48', 'admin', 1, '2016-04-16 12:20:48', null, null, null, 'Wheel', null);

insert into SAMPLE_PRODUCT
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, CUSTOMER_ID)
values ('3aa5673e-c96d-6051-ecb0-f176829cd4fd', '2016-04-16 12:19:45', 'admin', 2, '2016-04-16 12:26:08', 'admin', null, null, 'Toothpick', '405d5d7d-ed85-10e5-5e45-eeea2e574d18');

insert into SAMPLE_PRODUCT
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, CUSTOMER_ID)
values ('45983c56-91ca-5b0f-ae9f-589815da0ef9', '2016-04-16 12:21:43', 'admin', 2, '2016-04-16 12:26:18', 'admin', null, null, 'Refrigerator', '405d5d7d-ed85-10e5-5e45-eeea2e574d18');

insert into SAMPLE_PRODUCT
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, CUSTOMER_ID)
values ('5bfef093-968b-b745-0784-2d2dc5b4eb97', '2016-04-16 12:22:15', 'admin', 1, '2016-04-16 12:22:15', null, null, null, 'Cell phone', null);

insert into SAMPLE_PRODUCT
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, CUSTOMER_ID)
values ('e0b94e43-1aa1-159c-840e-d9e6da4294ba', '2016-04-16 12:21:56', 'admin', 1, '2016-04-16 12:21:56', null, null, null, 'Towel', null);
