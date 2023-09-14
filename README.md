# ADA LocateCar - Locadora de veículos
Criar uma aplicação que gerencie o aluguel de veículos, aplicando os conceitos vistos em aula, onde cada item abaixo seja considerado:

## 🚩Itens obrigatórios<br>

✅Cadastrar os veículos;<br>
✅Alterar um veículo cadastrado;<br>
✅Buscar um veículo por parte do nome;<br>
✅Cadastrar o cliente (pessoa física e jurídica)<br>
✅Alterar o cliente (pessoa física e jurídica)<br>
✅Alugar um veículo para pessoa física e jurídica;<br>
✅Devolver um veículo para pessoa física e jurídica;<br>

## 🚩Regras de negócio<br>

▪️ RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;<br>
▪️ RN2: Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;<br>
▪️ RN3: Os aluguéis e devoluções terão o local, data e horário;<br>
▪️ RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
▪️ RN5: Os veículos que estiverem alugados não poderão estar disponíveis;<br>
▪️ RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;<br>
▪️ RN7: Regras de devolução:<br>
Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.<br>
Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.<br>

## Valores base da diária por tipo de veículo:<br>

Tipo de Veículo	Valor por dia<br>
PEQUENO	    R$ 100,00<br>
MEDIO	      R$ 150,00<br>
SUV	        R$ 200,00<br>


## Entrega:<br>

O projeto pode possuir um menu iterativo ou uma classe com o método main contendo a exemplificação das funcionalidades.

## Requisitos Técnicos:
<img width="30" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"> Java 19 ou superior
