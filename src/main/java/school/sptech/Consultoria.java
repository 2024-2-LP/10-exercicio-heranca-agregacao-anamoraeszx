package school.sptech;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.List;
import school.sptech.especialistas.DesenvolvedorWeb;
import school.sptech.especialistas.DesenvolvedorMobile;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < getVagas()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double salario =0.0;
        for (Desenvolvedor dev: desenvolvedores){
            salario+= dev.calcularSalario();
        }

        return salario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int qtdMobile = 0;

        for(int i = 0; i < desenvolvedores.size(); i++){
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if(devDaVez instanceof DesenvolvedorMobile){
                qtdMobile++;
            }
        }
        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> maiores = new ArrayList<>();
        for (Desenvolvedor dev : desenvolvedores){
            if (dev.calcularSalario() >=salario ){
                maiores.add(dev);
            }
        }
        return maiores;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor devMenor = desenvolvedores.get(0);

        for (Desenvolvedor dev : desenvolvedores){
            if (dev.calcularSalario() <= devMenor.calcularSalario()){
                devMenor = dev;
            }
        }
        return devMenor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> tec = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if (devDaVez instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) devDaVez).getFrontend().contains(tecnologia)){
                    tec.add(devDaVez);
                }

                if (((DesenvolvedorWeb) devDaVez).getBackend().contains(tecnologia)){
                    tec.add(devDaVez);
                }

                if (((DesenvolvedorWeb) devDaVez).getSgbd().contains(tecnologia)){
                    tec.add(devDaVez);
                }
            }

            if (devDaVez instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) devDaVez).getLinguagem().contains(tecnologia)){
                    tec.add(devDaVez);
                }

                if (((DesenvolvedorMobile) devDaVez).getPlataforma().contains(tecnologia)){
                    tec.add(devDaVez);
                }
            }
        }
        return tec;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){

        Double salario = 0.0;

        List<Desenvolvedor> tec = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor dev : tec){
            salario+= dev.calcularSalario();
        }

        return salario;
    }




}
