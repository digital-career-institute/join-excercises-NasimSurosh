select product_name from products where supplier_id in(select supplier_id from suppliers where region = 'USA');

select orders.order_id, order_date, first_name, last_name
from orders join employees on orders.employee_id = employees.employee_id
where last_name like 'D%' and ship_country = 'Germany';

select from orders where ship_via = (select shipper_id from shippers where ship_name = 'United Package') and
shipped_date < '1996-08-12';

select company_name from shippers where shipper_id not in (select distinct shipper_id from orders);

select distinct orders.order_id from orders join order_details on orders.order_id = order_details.order_id
join products on order_details.product_id = products.product_id
where products.category_id = (select category_id from categories where category_name = 'Beverages')
and orders.order_date ='1996-08-14';

select products.product_name, products.units_in_stock from products join suppliers on products.supplier_id 
= suppliers.supplier_id
where suppliers.company_name = 'Lyngbysild' and products.category_id = (select category_id from categories
																	   where category_name ='Seafood');
																	   
																	   
select last_name from employees where region ='Northern'; 																	   
																

select employees.employee_id, last_name from employees join orders on employees.employee_id = orders.employee_id
where employees.employee_id in (select distinct employee_id from orders where order_date > '1996-07-18');


select distinct employees.employee_id, employees.first_name, employees.last_name from employees join
orders on employees.employee_id = orders.employee_id where employees.title = 'Warehouse Manager' and 
orders.shipped_date is null;

select orders.order_id, products.product_name, (order_details.unit_price *(1 - order_details.discount)) as totalprice
from orders join order_details on orders.order_id = order_details.order_id join products 
on order_details.product_id = products.product_id;


  
