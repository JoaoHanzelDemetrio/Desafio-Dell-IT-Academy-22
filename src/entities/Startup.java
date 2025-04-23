package entities;

public class Startup {

    private String nome;
    private String slogan;
    private int anoFundacao;
    private int totalPitchConvincente, totalProdutoComBugs,
            totalBoaTracaoDeUsuario, totalInvestidorIrritado, totalFakeNewsNoPitch;
    private static final int PONTOS = 70;


    public Startup(){
        this.pontos = PONTOS;
    }

    public Startup(String nome, String slogan, int anoFundacao) {
        this.nome = nome;
        this.slogan = slogan;
        this.anoFundacao = anoFundacao;
        this.pontos = PONTOS;
    }

    private int pontos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }


    public int getTotalPitchConvincente() {
        return totalPitchConvincente;
    }

    public void setTotalPitchConvincente(int totalPitchConvincente) {
        this.totalPitchConvincente = totalPitchConvincente;
    }

    public int getTotalProdutoComBugs() {
        return totalProdutoComBugs;
    }

    public void setTotalProdutoComBugs(int totalProdutoComBugs) {
        this.totalProdutoComBugs = totalProdutoComBugs;
    }

    public int getTotalBoaTracaoDeUsuario() {
        return totalBoaTracaoDeUsuario;
    }

    public void setTotalBoaTracaoDeUsuario(int totalBoaTracaoDeUsuario) {
        this.totalBoaTracaoDeUsuario = totalBoaTracaoDeUsuario;
    }

    public int getTotalInvestidorIrritado() {
        return totalInvestidorIrritado;
    }

    public void setTotalInvestidorIrritado(int totalInvestidorIrritado) {
        this.totalInvestidorIrritado = totalInvestidorIrritado;
    }

    public int getTotalFakeNewsNoPitch() {
        return totalFakeNewsNoPitch;
    }

    public void setTotalFakeNewsNoPitch(int totalFakeNewsNoPitch) {
        this.totalFakeNewsNoPitch = totalFakeNewsNoPitch;
    }

    @Override
    public String toString() {
        return "\nStartup{" +
                "nome='" + nome + '\'' +
                //", slogan='" + slogan + '\'' +
               // ", anoFundacao='" + anoFundacao + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
