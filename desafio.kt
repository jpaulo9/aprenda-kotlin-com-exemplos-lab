import java.text.Normalizer.Form

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nomeUsuario: String, val idade:Int, val rg:String)
data class ListaUsuario(val usurios:Collection<Usuario>)

fun ListaUsuario.MaisVelho():Int = this.usurios.maxByOrNull { it.idade }?.idade ?: 0

data class ConteudoEducacional(var nome: String, val duracao: Int, val enum: Nivel )

data class Formacao(val curso: String, var conteudos: List<ConteudoEducacional>, var inscritos: List<Usuario>){

    fun listarConteudos (){
        for (conteudo in conteudos) {
            println("Disciplina: ${conteudo.nome} | Duração: ${conteudo.duracao} | Nível: ${conteudo.enum} ")
        }
    }
    fun listarAlunos (){
        var listaOrd = inscritos.sortedBy { it.nomeUsuario }
     for (aluno in listaOrd) {
            println("Nome: ${aluno.nomeUsuario} | Idade: ${aluno.idade} | RG: ${aluno.rg} ")
        }

        val alunoMaisVelho = ListaUsuario(listaOrd)
        for(idad in listaOrd){
            if(idad.idade === alunoMaisVelho.MaisVelho())
                println("Aluno mais velho da turma é ${idad.nomeUsuario}," +
                        " têm ${alunoMaisVelho.MaisVelho()} anos de idade")
        }

    }

}

fun main() {

    val ingles1 = ConteudoEducacional("Inglês I", 120, Nivel.BASICO)
    val ingles2 = ConteudoEducacional("Inglês II", 100, Nivel.INTERMEDIARIO)
    val ingles3 = ConteudoEducacional("Inglês III", 120, Nivel.INTERMEDIARIO)
    val ingles4 = ConteudoEducacional("Inglês IIII", 130, Nivel.AVANCADO)
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(ingles1)
    listConteudos.add(ingles2)
    listConteudos.add(ingles3)
    listConteudos.add(ingles4)

    val alunoIngles1 = Usuario("Lucas", 23, "1263152")
    val alunoIngles2 = Usuario("Davi", 18, "1263152")
    val alunoIngles3 = Usuario("Eliana", 21, "1263152")
    val alunoIngles4 = Usuario("Jovelina", 29, "1263152")
    val alunoIngles5 = Usuario("Clara", 25, "1263152")
    val listUsuario = mutableListOf<Usuario>()
    listUsuario.add(alunoIngles1)
    listUsuario.add(alunoIngles2)
    listUsuario.add(alunoIngles3)
    listUsuario.add(alunoIngles4)
    listUsuario.add(alunoIngles5)



    val matriculaCurso = Formacao("Curso de Inglês", listConteudos, listUsuario)


    println("--- Curso ---\n"+matriculaCurso.curso)
    println("--- Grade Curricular ---")
    matriculaCurso.listarConteudos()
    println("--- Turma ---")
    matriculaCurso.listarAlunos()





}
