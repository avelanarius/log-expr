# LogExpr
**LogExpr** is a simple desktop application, **automatically** solving a variety of logical and arithmetic problems. It is based on Microsoft [Z3 theorem prover](https://github.com/Z3Prover/z3). It supports **logical** expressions (`or`, `and`, `implies`, more...), as well as **arithmetic** expressions on integers (`+`, `*`, more...). 

It can be used to automatically **prove theorems**, **find counterexamples** or explore solutions to a given problem. 

## Examples

### Sum of two positive numbers is positive
<img src="https://raw.githubusercontent.com/avelanarius/log-expr/documentation/img/sum_of_two_non_negative.PNG" height="550px">

| Defintion part | Value |
| --- | --- |
| Description | Automatically proof that sum of two positive numbers is positive. |
| Domain | `first > 0 && second > 0` |
| Logical condition | `first + second > 0` |
| **Result** | **Condition is always true.** |
