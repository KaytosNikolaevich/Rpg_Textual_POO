# Gênesis Mágica

**Desenvolvido por: Kevin Kawan Dias**

## Descrição do Projeto
Antes de mais nada, gostaria de agradeçer a proposta do trabalho, pois é um projeto que envolve algo que gosto muito, o rpg de mesa. E com isso pude usar uma história que venho trabalhando a um tempo ( 2 anos).
Além disso, vale ressaltar que aqui será um oneShot, não uma história completa. Sou novo na turma e não tive colegas conhecidos para fazer em grupo, então fiz tudo sozinho e fui tirando minhas dúvidas com IA's e com muitos Devs que conheço. Um ponto importante é, com isso aprendi muito a codificar em Java. Algo que até então eu era ruim ou até mesmo em alguns casos, mediocre. Vamos ao que interessa. O projeto:

Gênesis Mágica é um RPG ambientado no mundo de Avalon, inspirado na cultura da China medieval, mas com diversas liberdades criativas. Os jogadores vivenciam uma narrativa rica, repleta de aventuras, desafios e decisões que moldam o destino de seus personagens.

## Integrantes do Grupo

- Kevin Kawan Dias - 1142742757 - BEC

## Link do Repositório

[Repositório no GitHub](https://github.com/KaytosNikolaevich/Rpg_Textual_POO.git)

## Como Executar o Código

Para executar o jogo, siga os passos abaixo:

**Clone o Repositório**:
   ```bash
   git clone https://github.com/KaytosNikolaevich/Rpg_Textual_POO.git
Vá até o diretório do meu projeto RPG_Textual_POO
Certifique-se de que o JDK (Java Development Kit) está instalado:

Você pode baixar o JDK aqui.
Compile o Código:

Utilize o terminal ou um IDE (como IntelliJ IDEA ou Eclipse) para compilar os arquivos Java.
Execute o Jogo:

Execute a classe Main para iniciar o jogo.

Funcionalidade:
Criação de Personagem: Os jogadores podem criar seus personagens, escolhendo nome, idade e especialização.
Sistema de Atributos: Os jogadores distribuem pontos em atributos como Força, Destreza, Resistência, Potência e Persuasão.
Escolhas Narrativas: As decisões dos jogadores influenciam a história e os resultados dos combates.
Combate com Criaturas: Os jogadores enfrentam inimigos como o Wendigo, com resultados baseados em suas escolhas e atributos. 



Aplicação de Conceitos solicitados>
Aplicação de Encapsulamento:

Atributos das classes são privados e acessados através de métodos públicos (getters e setters).
Exemplo: getNome(), setIdade(int idade).
Aplicação de Herança:

CultivoQi e CultivoElemento herdam de Especializacao.
Exemplo: public class CultivoQi extends Especializacao.
Aplicação de Polimorfismo:

Métodos em Habilidade que são implementados de forma diferente nas subclasses.
Exemplo: public void usar() em BolaDeFogo e GalopeDoPegaso.
Aplicação de Classe Abstrata e/ou Interface:

Habilidade pode ser uma classe abstrata, exigindo implementações específicas nas subclasses.
Exemplo: Métodos abstratos definidos em Habilidade.
Aplicação de Composição e/ou Agregação:

A classe Personagem contém uma instância de Especializacao, mostrando uma relação de composição.
Exemplo: private Especializacao especializacao.
Aplicação de Tratamento de Exceções:

Uso de try-catch nas operações que podem gerar exceções, como divisões ou acessos a elementos de uma lista.
Exemplo: Tratamento de exceções em Combate.
