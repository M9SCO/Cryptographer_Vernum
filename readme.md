#  Cryptographer Vernum

Simple repo for viewing what working method Vernum.  
  
## What this work?  
  
  
this is crypto symmetrical method with use binary XOR

| A   | B   | Res |
|-----|-----|-----|
| 1   | 0   | 1   |
| 0   | 1   | 1   |
| 0   | 0   | 0   |
| 1   | 1   | 0   |

## Example:    
Crypt "Hello" with key "11100111"   
  
"Hello" -> "01001000 01100101 01101100 01101100 01101111"

01001000 XOR 11100111 -> 10101111  
01100101 XOR 11100111 -> 10000010  
01101100 XOR 11100111 -> 10001011  
01101100 XOR 11100111 -> 10001011  
01101111 XOR 11100111 -> 10001000  

"10101111 10000010 10001011 10001011 10001000 " -> "�����"  
If you dnt'know key, you can't get original string 