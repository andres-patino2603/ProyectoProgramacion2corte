
package Modelo;
public class Cuentas {
    long NoCuenta;

    public Cuentas(long NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public Cuentas() {
    }

    public long getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(long NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    @Override
    public String toString() {
        return  String.valueOf(NoCuenta);
    }
    
}
