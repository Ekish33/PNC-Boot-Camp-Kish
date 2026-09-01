In file person
1.constructor breakd down is
    aload0 = push "this" onto the internal stack at 0
    invokespecial calls the parent class constructor
    aload0 push this again 
    aload 1 pushs first parameter name to slot 1 since this object is in 0
    putfield pops this and name which stores the paramtrer value into objects name field
    aload0 and iload2 repeat the same process gain for age
    putfield pops the value in like last
    return exits the constrcutor

2. Display calls the static field and loads in both paremeters and pushs it in then return

3. Aload = loaded a object into the stack putfield = add values to object or parameters return ends the method or constructor

