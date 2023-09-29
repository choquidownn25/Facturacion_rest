package org.exemple.utils;

public enum StringResponse {

    ErrorSAVETICKET("Usuario Y Apellido  solo permitido hasta 20 caracteres",8),
    ErrorREMOVETICKET("No se puede eliminar Usuario",9),
    ErrorNOHAYTICKET("Usuario no encontrado",10),
    ErrorSUPDATETICKET("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",11),
    ACTIVOSTATUS("1", 12),
    ERRORFECHA("Error formato de fecha", 13),
    MOSTRARTICKET("Usuario Encontrado", 14),
    ErrorSUPDATE("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",401),
    OK("Registro agregado",200);



    private String name;
    private int code;


    private StringResponse (String name, int code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
