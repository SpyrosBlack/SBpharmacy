-- populate user table
INSERT INTO `pharmacydb`.`app_user` (`firstname`, `lastname`, `username`, `userpassword`, `role`) VALUES ('Lakis', 'Spiros', 'Spiros', '1234', 'Pharmacist');
INSERT INTO `pharmacydb`.`app_user` (`firstname`, `lastname`, `username`, `userpassword`, `role`) VALUES ('Lakis', 'Spiros', 'Kostas', '1234', 'Pharmacist');
INSERT INTO `pharmacydb`.`app_user` (`firstname`, `lastname`, `username`, `userpassword`, `role`) VALUES ('Lakis', 'Lakis', 'Lakis', '1234', 'Admin');

-- populate medicines
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (23, 'Medicine 1');
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (2, 'Medicine 2');
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (56, 'Medicine 3');

-- populate pharmacy table
INSERT INTO `pharmacydb`.`pharmacy` (`pharmacyaddress`, `pharmacycity`, `pharmacyname`, `lat`, `lng`, `username`) VALUES ('lala', 'lala', 'lala', 38.1725, 23.725, 'Spiros');
INSERT INTO `pharmacydb`.`pharmacy` (`pharmacyaddress`, `pharmacycity`, `pharmacyname`, `lat`, `lng`, `username`) VALUES ('lala', 'lala', 'lala', 38.1725, 23.725, 'Kostas');

-- populate inventory table
INSERT INTO `pharmacydb`.`inventory` (`dateofcount`, `medicineid`, `pharmacyid`, `quantity`) VALUES ('2025-11-03', 1, 1, 33);
INSERT INTO `pharmacydb`.`inventory` (`dateofcount`, `medicineid`, `pharmacyid`, `quantity`) VALUES ('2025-11-03', 2, 1, 33);
INSERT INTO `pharmacydb`.`inventory` (`dateofcount`, `medicineid`, `pharmacyid`, `quantity`) VALUES ('2025-11-03', 3, 1, 33);
INSERT INTO `pharmacydb`.`inventory` (`dateofcount`, `medicineid`, `pharmacyid`, `quantity`) VALUES ('2025-11-03', 2, 1, 33);
INSERT INTO `pharmacydb`.`inventory` (`dateofcount`, `medicineid`, `pharmacyid`, `quantity`) VALUES ('2025-11-03', 1, 1, 33);

-- populate orders
INSERT INTO `pharmacydb`.`pharmaorder` (`orderdate`, `pharmacyid`, `orderid`) VALUES ('2024-11-16', 1, 1);
INSERT INTO `pharmacydb`.`pharmaorder` (`orderdate`, `pharmacyid`, `orderid`) VALUES ('2024-11-16', 3, 2);

INSERT INTO `pharmacydb`.`pharmaorderitem` (`medicineid`, `orderitemid`, `quantity`, `orderid`) VALUES (1, 1, 22, 1);
INSERT INTO `pharmacydb`.`pharmaorderitem` (`medicineid`, `orderitemid`, `quantity`, `orderid`) VALUES (2, 2, 22, 1);
INSERT INTO `pharmacydb`.`pharmaorderitem` (`medicineid`, `orderitemid`, `quantity`, `orderid`) VALUES (2, 3, 22, 2);
