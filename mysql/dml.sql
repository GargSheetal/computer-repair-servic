show databases;
use computer_repair_service;
select * from customer;

-- insert into customer(last_name, rest_of_name, email, phone) 
	values('Shelton', 'Mark',  'ms@gmail.com', '2345645678'),
	('Potter', 'Harry', 'hp@gmail.com', '3456789012'),
	('Parker', 'Peter', 'pp@gmail.com', '4567890123'),
	('Jane', 'Mary', 'mj@gmail.com', '5678901234');

-- insert into device_brand(brand_name)
	values('Apple'),
    ('Samsung'),
    ('Microsoft'),
    ('Google');

-- insert into device_category(device_category_name, device_brand_id)
	values('smartphone', 1),
    ('smartphone', 2),
    ('smartphone', 4),
    ('tablet', 1),
    ('tablet', 2),
    ('tablet', 3),
    ('laptop', 1),
    ('laptop', 3),
    ('laptop', 4);
    
-- insert into device(device_name, device_category_id)
	values('iPhone 14', 1),
    ('iPhone 13', 1),
    ('Galaxy S20', 2),
    ('Galaxy A14', 2),
    ('Pixel 6', 3),
    ('Pixel 7', 3),
    ('iPad Air', 4),
    ('iPad Pro', 4),
    ('Note 10', 5),
    ('Note 7', 5),
    ('Surface 1', 6),
    ('Surface 3', 6),
    ('Macbook Pro', 7),
    ('Macbook Air', 7),
    ('Windows 11 Pro', 8),
    ('Windows 10 Pro', 8),
    ('Chromebook 5', 9),
    ('Chromebook 7', 9);

-- alter table customer_device modify serial_number varchar(45); -- changed column type from int to varchar
-- insert into customer_device(customer_id, device_id, serial_number)
	values(1, 1,'iphone14-001'),
    (1, 13,'macbookpro-001'),
    (2, 3,'galaxys20-002'),
    (2, 9,'note10-002'),
    (3, 5,'pixel6-003'),
    (3, 17,'chromebook5-003'),
    (4, 11,'surface1-004');

-- insert into technician(last_name, rest_of_name, email, phone) 
	values('Stark', 'Tony', 'ironman@marvel.com', '1112223333'),
    ('Rogers', 'Steve', 'captainamerica@marvel.com', '2223334444'),
    ('Thor', null, 'odinson@marvel.com', '3334445555');
       
-- insert into service(device_id, service_description, price)
	values(1, 'Screen Replacement', 200.00),
    (1, 'Battery Replacement', 70.00),
    (2, 'Malware Removal', 400.00);
-- insert into service(device_id, service_description, price)
    values(3, 'Screen Replacement', 100.00);
    
-- insert into service_technician(service_id, technician_id, skill_level)
	values(1, 2, 1),
    (2, 3, 3),
    (3, 1, 2);
-- insert into service_technician(service_id, technician_id, skill_level)
	values(4, 2, 2);
    
-- alter table service_request drop column status; -- dropped column
-- alter table service_request modify amount decimal(10,2); -- made field nullable
-- insert into service_request(customer_device_id, service_id, created_timestamp, service_request_description)
	values(1, 1, '2023-01-23 12:45:56', 'please do screen replacement for my iPhone14. Thanks Mark Shelton'),
    (2, 3, '2023-01-27 12:45:56', 'please do malware removal from my Macbook Pro. Thanks Mark Shelton'),
    (3, 4, '2023-02-15 12:45:56', 'please do screen replacement for my Galaxy S20. Thanks Mark Shelton');
    
-- update service_request 
	set service_request_description = 'please do screen replacement for my Galaxy S20. Thanks Harry Potter' 
    where service_request_id = 3;
    
-- alter table service_request_appointment add service_request_appointment_id int NOT NULL AUTO_INCREMENT PRIMARY KEY; -- added a new column as primary key (not likely to be done in a real app)
-- alter table service_request_appointment modify technician_notes varchar(400) -- made field nullable
-- insert into service_request_appointment(service_request_id, technician_id, appointment_timestamp)
	values(1, 2, '2023-01-25 11:00:00'),
    (1, 2, '2023-01-27 12:00:00'),
    (2, 1, '2023-01-29 11:00:00'),
	(3, 2, '2023-02-18 11:00:00');

-- insert into service_request_payment(service_request_id, amount, payment_timestamp, payment_confirmation_number)
	values(1, 200.00, '2023-01-27 12:00:00', 'abc123xyz')
    
-- UPDATE service_request 
SET last_updated_timestamp = '2023-01-27 12:00:00', 
completed_timestamp = '2023-01-27 12:00:00', 
amount = 200.00 
WHERE service_request_id = 1;

-- UPDATE service_request 
SET last_updated_timestamp = '2023-01-27 12:00:00'
WHERE service_request_id = 2;

-- UPDATE service_request 
SET last_updated_timestamp = '2023-02-18 11:00:00'
WHERE service_request_id = 3;

-- UPDATE customer 
SET phone = '222244446'
WHERE customer_id = 1;

-- UPDATE service
SET price = 300
WHERE service_id = 1;

-- UPDATE service_request_appointment
SET technician_notes = 'Ordered new screen'
WHERE service_request_id = 3;

-- DELETE from device 
WHERE device_id = 12;

-- DELETE from customer_device
WHERE customer_id = 4;

-- DELETE from customer
WHERE customer_id = 4;

-- DELETE from device_brand
WHERE device_brand_id = 2;

-- DELETE from device_categoty
WHERE device_category_id = 3;

-- DELETE from device_categoty
WHERE device_category_id = 2;

-- DELETE from service
WHERE service_id = 1;

-- DELETE from service_request
WHERE service_request_id = 3;


-- inner join
SELECT c.*, cd.* from customer c 
INNER JOIN customer_device cd
ON c.customer_id = cd.customer_id;		

-- LEFT join
SELECT d.device_id, d.device_name, d.device_category_id, s.service_id, s.service_description, s.price 
FROM device d LEFT JOIN service s 
ON d.device_id = s.device_id;

-- RIGHT join
SELECT s.service_id, s.service_description, s.price, d.device_id, d.device_name, d.device_category_id FROM service s
RIGHT JOIN device d ON s.device_id = d.device_id;

-- FULL join
SELECT s.service_id, s.service_description, s.price, sr.service_request_id, sr.customer_device_id, sr.created_timestamp, sr.amount
FROM service s 
LEFT JOIN service_request sr ON s.service_id = sr.service_id
UNION 
SELECT s.service_id, s.service_description, s.price, sr.service_request_id, sr.customer_device_id, sr.created_timestamp, sr.amount
FROM service_request sr 
RIGHT JOIN service s ON sr.service_id = s.service_id;

-- CROSS JOIN
SELECT sr.service_request_id, sr.customer_device_id, sr.amount, srp.payment_confirmation_number, srp.payment_timestamp
FROM service_request sr
CROSS JOIN service_request_payment srp;

-- get the count of device_category for each brand
SELECT device_brand_id, count(*)
FROM device_category
GROUP BY device_brand_id;

-- get the timestamp of most recent appointment for each service request
SELECT service_request_id, max(appointment_timestamp) AS last_updated_at
FROM service_request_appointment
GROUP BY service_request_id;

--  technician_count for each service
SELECT s.service_id, count(*) AS technician_count
FROM service_technician st RIGHT JOIN service s ON 
st.service_id = s.service_id
GROUP BY s.service_id;

--  customer device count for each device 
SELECT d.device_id AS d_devc_id, cd.device_id AS c_devc_id, count(cd.device_id) AS registered_customer_device_count
FROM customer_device cd RIGHT JOIN device d ON 
d.device_id = cd.device_id 
GROUP BY d.device_id;

-- get the service request count by device brands
SELECT db.device_brand_id, count(*) AS service_request_count
FROM service_request sr, customer_device cd, device d, device_category dc, device_brand db
WHERE sr.customer_device_id = cd.customer_device_id
AND cd.device_id = d.device_id
AND d.device_category_id = dc.device_category_id
AND dc.device_brand_id = db.device_brand_id
GROUP BY db.device_brand_id;

-- get the brands with more than 2 device_category
SELECT device_brand_id, count(*)
FROM device_category
GROUP BY device_brand_id
HAVING count(*) > 2;

-- get all service_requests that have their most recent appointments on or before 31-Jan-2023
SELECT service_request_id, max(appointment_timestamp)
FROM service_request_appointment
GROUP BY service_request_id
HAVING max(appointment_timestamp) <= '2023-01-31 00:00:00';

-- get all technicians with avg skill level >= 2
SELECT technician_id, avg(skill_level) avg_skill_level
FROM service_technician
GROUP BY technician_id
HAVING avg_skill_level >= 2;

select * from service;
-- get number of services by device
SELECT device_id, count(*) AS offered_services_count
FROM service
GROUP BY device_id;

-- get number of services priced > 100, by device
SELECT device_id, count(*) AS offered_services_count
FROM service WHERE price >100 
GROUP BY device_id; 

-- display device names and number of services offered, priced > 100 group by device
SELECT d.device_id, count(*) AS offered_services_count, MIN(d.device_name) AS device_name
FROM service s, device d 
WHERE s.price > 0 
AND s.device_id = d.device_id
GROUP BY s.device_id;

-- display device names and number of services offered group by device that have more than one service offering
SELECT d.device_id, count(*) AS offered_services_count, MIN(d.device_name) AS device_name
FROM service s, device d 
WHERE s.device_id = d.device_id
GROUP BY s.device_id
HAVING count(*) > 1;

-- get service_request count group by their created timestamp in month/year format, having > 1 service request
SELECT DATE_FORMAT(sr.created_timestamp, "%Y-%m") AS created_month, count(*) AS service_req_count
FROM service_request sr
GROUP BY DATE_FORMAT(sr.created_timestamp, "%Y-%m")
HAVING count(*) > 1;

-- join all tables
SELECT c.rest_of_name, c.last_name, c.email, c.phone, d.device_name, dc.device_category_name, dbr.brand_name,
s.service_description, s.price, sr.service_request_description, sra.appointment_timestamp, sra.technician_notes,
srp.amount, srp.payment_confirmation_number, st.skill_level, t.rest_of_name, t.last_name, t.email, t.phone
FROM customer c, customer_device cd, device d, device_category dc, device_brand dbr,
service s, service_request sr, service_request_appointment sra, service_request_payment srp,
service_technician st, technician t
WHERE c.customer_id = cd.customer_id
AND cd .device_id = d.device_id
AND d.device_category_id = dc.device_category_id
AND dc.device_brand_id = dbr.device_brand_id
AND sr.customer_device_id = cd.customer_device_id
AND sra.service_request_id = sr.service_request_id
AND srp.service_request_id = sr.service_request_id
AND s.service_id = st.service_id
AND st.technician_id = t.technician_id
