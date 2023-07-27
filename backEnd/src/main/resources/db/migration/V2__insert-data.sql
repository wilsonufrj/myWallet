/**
 * Author:  wilson
 * Created: Jul 26, 2023
 */
INSERT INTO wallet(id,name,description) VALUES
(1,'janeiro','carteira de Janeiro'),
(2,'Fevereiro','carteira de Fevereiro'),
(3,'Março','carteira de Março'),
(4,'Abril','carteira de Abril'),
(5,'Maio','carteira de Maio'),
(6,'Junho','carteira de Junho'),
(7,'Julho','carteira de Julho'),
(8,'Agosto','carteira de Agosto'),
(9,'Setembro','carteira de Setembro'),
(10,'Outubro','carteira de Outubro'),
(11,'Novembro','carteira de Novembro'),
(12,'Dezembro','carteira de Dezembro');

INSERT INTO health(id,credit_limit,debit_limit,close_month,investiment,id_wallet) VALUES
(1,400.0,700.0,FALSE,300,1),
(2,400.0,700.0,FALSE,300,2),
(3,400.0,700.0,FALSE,300,3),
(4,400.0,700.0,FALSE,300,4),
(5,400.0,700.0,FALSE,300,5),
(6,400.0,700.0,FALSE,300,6),
(7,400.0,700.0,FALSE,300,7),
(8,400.0,700.0,FALSE,300,8),
(9,400.0,700.0,FALSE,300,9),
(10,400.0,700.0,FALSE,300,10),
(11,400.0,700.0,FALSE,300,11),
(12,400.0,700.0,FALSE,300,12);


INSERT INTO transaction(id,client,value,name,date,description,id_wallet,type_transaction) VALUES
(1,'wilson',65.0,'academia','20230101','custo com a academia',1,1),
(2,'wilson',2900,'salario','20230110','salario do mes',1,0),
(3,'wilson',300,'investimento','20230110','Investimento para a riqueza',1,2),
(4,'wilson',100,'internet','20230110','custo com a internet',1,1);

