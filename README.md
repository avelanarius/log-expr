# LogExpr
**LogExpr** is a simple desktop application, **automatically** solving a variety of logical and arithmetic problems. It is based on Microsoft [Z3 theorem prover](https://github.com/Z3Prover/z3). It supports **logical** expressions (`or`, `and`, `implies`, more...), as well as **arithmetic** expressions on integers (`+`, `*`, more...). 

It can be used to automatically **prove theorems**, **find counterexamples** or explore solutions to a given problem. 

## Examples

### Prove that sum of two positive numbers is positive
<img src="https://raw.githubusercontent.com/avelanarius/log-expr/master/img/sum_of_two_non_negative.PNG" height="550px">

| Aspect | Description |
| --- | --- |
| Description | Automatically prove that sum of two positive numbers is positive. |
| Domain | `first > 0 && second > 0` |
| Logical condition | `first + second > 0` |
| **Result** | **Condition is always true.** Theorem proved for all positive numbers. |

### Find solutions for logical expression
<img src="https://raw.githubusercontent.com/avelanarius/log-expr/master/img/logical_expression.PNG" height="550px">

| Aspect | Description |
| --- | --- |
| Description | Find all solutions for logical expression: `a && (b => c) && (b \|\| d)`. |
| Domain | Empty. |
| Logical condition | `a && (b => c) && (b \|\| d)` |
| **Result** | **Condition can be false or true.** *"Show example"* buttons allow you to explore the solutions. |
| False solution (1) | `a = false, b = false, c = false, d = false ` |
| True solution (1) | `a = true, b = true, c = true, d = false ` |

### Bussiness logic edge case exploration
<img src="https://raw.githubusercontent.com/avelanarius/log-expr/master/img/business_logic.PNG" height="550px">

| Aspect | Description |
| --- | --- |
| Description | A company is buying at most 1000 products, priced at $75. If they order less than 500, then the price is raised to $160. Can the order value exceed $80.000? |
| Domain | `orderCount > 0 && orderCount <= 1000 && orderPrice == (if orderCount < 500 then 160 else 75)` |
| Logical condition | `orderCount * orderPrice > 80000` |
| **Result** | **Condition is always false.** Order value cannot exceed $80.000. |
