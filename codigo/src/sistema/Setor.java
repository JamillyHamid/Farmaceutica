package sistema;
import java.util.ArrayList;
import java.util.List;

public class Setor {
    private String nomeSetor;
    private List<Funcionario> funcionarios;

    public Setor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
        this.funcionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(String idFuncionario) {
        funcionarios.removeIf(f -> f.getId().equals(idFuncionario));
    }

    public Funcionario buscarFuncionario(String idFuncionario) {
        return funcionarios.stream()
                .filter(f -> f.getId().equals(idFuncionario))
                .findFirst()
                .orElse(null);
    }

    public int getQuantidadeFuncionarios() {
        return funcionarios.size();
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário neste setor.");
            return;
        }
        funcionarios.forEach(System.out::println);
    }

    // --- Getters ---
    public String getNomeSetor() {
        return nomeSetor;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public String toString() {
        return "Setor: " + nomeSetor + " (" + getQuantidadeFuncionarios() + " funcionários)";
    }
}
