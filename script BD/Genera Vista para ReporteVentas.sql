create view reporteventas AS



select 
d.usu_id as "usu_id",
per.per_primer_nombre as "nombre", 
per.per_primer_apelido as "apellido", 
extract(month from f.com_fecha) as "mes",
extract(year from f.com_fecha) as "ano", 
sum (pd.pro_dis_cantidad * d.dis_valor) as "total"
from 
productodisenado pd, 
disenosxproddis dp, 
diseno d, proddisxcompra e, 
compra f, 
usuario usr, 
persona per
where f.com_id = e.com_id and e.pro_dis_id = pd.pro_dis_id and d.usu_id = usr.usu_id and usr.per_id = per.per_id and
pd.pro_dis_id=dp.pro_dis_id and dp.dis_id=d.dis_id
group by d.usu_id, extract(month from f.com_fecha), extract(year from f.com_fecha), per.per_primer_nombre, per.per_primer_apelido
order by d.usu_id



;

