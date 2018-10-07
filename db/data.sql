-- s_role table
INSERT INTO public.s_role(role_id, role_name, description) VALUES ('1', 'ADMIN', 'Admin user');
INSERT INTO public.s_role(role_id, role_name, description) VALUES ('2', 'USER', 'Standard user');

-- m_user table
INSERT INTO public.m_user(user_id, username, password, full_name, create_time, update_time)
	VALUES ('1', 'admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'Admin', current_timestamp, current_timestamp);
INSERT INTO public.m_user(user_id, username, password, full_name, create_time, update_time)
	VALUES ('2', 'thanhpl', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'Phan Le Thanh', current_timestamp, current_timestamp);
	
-- m_user_role table
INSERT INTO public.m_user_role(user_id, role_id) VALUES ('1', '1');
INSERT INTO public.m_user_role(user_id, role_id) VALUES ('1', '2');
INSERT INTO public.m_user_role(user_id, role_id) VALUES ('2', '2');