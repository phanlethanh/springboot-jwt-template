-- s_role table
INSERT INTO public.s_role(role_id, role_name, privileges, description) 
	VALUES ('1', 'Admin', 'ADMIN,USER', 'Admin user');
INSERT INTO public.s_role(role_id, role_name, privileges, description) 
	VALUES ('2', 'User', 'USER', 'Standard user');

-- m_user table
INSERT INTO public.m_user(user_id, username, password, full_name, role_id, create_time, update_time)
	VALUES ('1', 'admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'Admin', '1', current_timestamp, current_timestamp);
INSERT INTO public.m_user(user_id, username, password, full_name, role_id, create_time, update_time)
	VALUES ('2', 'thanhpl', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'Phan Le Thanh', '2', current_timestamp, current_timestamp);
