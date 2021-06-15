INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'admin',
    'craston@email.com',
    'Cranston',
    '15988116144',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'admin',
    'bend@email.com',
    'Bend',
    '15988116120',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'admin',
    'tonawanda@email.com',
    'Tonawanda',
    '15988116122',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'admin',
    'cranberry@email.com',
    'Cranberry ',
    '15988116125',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'attendees',
    'valley@email.com',
    'Valley',
    '15988116130',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'attendees',
    'race@email.com',
    'Race ',
    '15988116126',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'attendees',
    'armstrong@email.com',
    'Armstrong',
    '15988116128',
    0.0
  );
INSERT INTO public.tb_users (role, email, name, phone_number, balance)
VALUES(
    'attendees',
    'manor@email.com',
    'Manor ',
    '15988116129',
    0.0
  );

INSERT INTO public.tb_place (address, name)
VALUES('Homestead Street', 'Homestead');

INSERT INTO public.tb_place (address, name)
VALUES('Goodlettsville St', 'Lakeview');

INSERT INTO public.tb_place (address, name)
VALUES('Sunbeam Street', 'Sunbeam');

INSERT INTO public.tb_place (address, name)
VALUES('Lakeview  Street', 'Lakeview ');

INSERT INTO public.tb_event (
    description,
    email_contact,
    end_date,
    end_time,
    name,
    start_date,
    start_time,
    amount_free_tickets,
    amount_payed_tickets,
    price_ticket,
    free_tickets_selled,
    payed_tickets_selled,
    admin_id
  )
VALUES(
    'Será um evento legal',
    'vinicius.cardoso@facens.br',
    '2021-03-28',
    '19:00:00',
    'Evento do Joga18',
    '2021-03-21',
    '16:30:00',
    5,
    5,
    60.99,
    0,
    0,
    1
  );
INSERT INTO public.tb_event (
    description,
    email_contact,
    end_date,
    end_time,
    name,
    start_date,
    start_time,
    amount_free_tickets,
    amount_payed_tickets,
    price_ticket,
    free_tickets_selled,
    payed_tickets_selled,
    admin_id
  )
VALUES(
    'Será um evento legal',
    'vinicius.cardoso@facens.br',
    '2021-03-28',
    '19:00:00',
    'Evento do Joga18',
    '2021-03-21',
    '16:30:00',
    5,
    5,
    60.99,
    0,
    0,
    1
  );
INSERT INTO public.tb_event (
    description,
    email_contact,
    end_date,
    end_time,
    name,
    start_date,
    start_time,
    amount_free_tickets,
    amount_payed_tickets,
    price_ticket,
    free_tickets_selled,
    payed_tickets_selled,
    admin_id
  )
VALUES(
    'Será um evento legal para caramba.',
    'vinicius.cardoso23@etec.sp.gov.br',
    '2021-07-22',
    '15:00:00',
    'Evento do Joga11',
    '2021-07-20',
    '13:00:00',
    5,
    5,
    99.99,
    0,
    0,
    2
  );
INSERT INTO public.tb_event (
    description,
    email_contact,
    end_date,
    end_time,
    name,
    start_date,
    start_time,
    amount_free_tickets,
    amount_payed_tickets,
    price_ticket,
    free_tickets_selled,
    payed_tickets_selled,
    admin_id
  )
VALUES(
    'Será um evento legal',
    'manor@email.com',
    '2021-03-22',
    '15:00:00',
    'Evento do Joga11',
    '2021-03-20',
    '13:00:00',
    5,
    5,
    99.99,
    0,
    0,
    2
  );


INSERT INTO public.tb_places_events (event_id,place_id)
	VALUES (1,1);
INSERT INTO public.tb_places_events (event_id,place_id)
	VALUES (2,2);
INSERT INTO public.tb_places_events (event_id,place_id)
	VALUES (3,2);
