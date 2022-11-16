DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_GL_STATEMENT`(IN `BranchCode` TEXT, IN `GLCODE` TEXT)
    NO SQL
BEGIN
DECLARE Balance Double DEFAULT 0;
 SELECT
    `glcode`,
    `tran_date`,
    `tran_branch`,
    `tran_sl`,
    `credit_amt`,
    `debit_amt`,
    `credit_amt` - `debit_amt` balance,
    case when `credit_amt` - `debit_amt`<0 then 'Dr' else 'Cr' end BalStatus
FROM
    `as_transaction`
WHERE
    `tran_branch`='0018';
END$$
DELIMITER ;