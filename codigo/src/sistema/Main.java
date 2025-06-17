package sistema;

import views.Login;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        new Login(empresa);
    }
}