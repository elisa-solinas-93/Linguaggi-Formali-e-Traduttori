Consideriamo la seguente nuova definizione di identificatori: un identificatore
è una sequenza non vuota di lettere, numeri e il simbolo di underscore. 
La sequenza non comincia con un numero e non puo' essere composta dal solo simbolo
di underscore. 
Piu' precisamente, gli identificatori corrispondono all'espressione regolare:
    ([a-zA-Z] (_(_)* [a-zA-Z0-9])) ([a-zA-z0-9]|_)*
Estendere il metodo lexical_scan per gestire identificatori che corrispondono 
alla nuova definizione.