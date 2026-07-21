# Write your MySQL query statement below
select a.customer_id, count(a.visit_id) as count_no_trans
from Visits as a
left join Transactions as t
on t.visit_id=a.visit_id
where t.transaction_id is null
group by a.customer_id;