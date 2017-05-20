## Requesitos para a primeira apresentação:

- Carregar/gravar	a	informação de/em	ficheiro:
    1. os Aeroportos ✔️
    2. os Aviões ✔️
- Imprimir toda	a	informação	relativa	a	um	determinado	aeroporto;
    *  ✔️
- Imprimir	toda	a	informação	relativa	a	um	determinado	avião;
     *  ✔️
- Imprimir	todos	os	aviões	que	estão	num	determinado	aeroporto;
     *  ✔️
- Imprimir	todos	os	aeroportos de	um	determinado	país	ou	continente;
    *  ✔️
- Imprimir	 todas	 as	 viagens	 com	 origem/destino	 num	 determinado	
aeroporto;
    *  ✔️
- Imprimir	todas	as	viagens	realizadas	por	um	determinado	avião;
    *  ✔️
- Imprimir	 todas	 as	 viagens	 realizadas	 entre	 um	 determinado	 período	 de	
tempo;
    *  ✔️
- Determinar	qual	o	aeroporto	com	mais	tráfego;
    *  ✔️
- Determinar	qual	    ️o	voo	que	transportou	mais	passageiros;
    *  ✔️
- Determinar	 qual	 o	 aeroporto	 que	 transportou	 o	 maior	 número	 de	
passageiros.
	*  ✔️
- Inserir,	 remover,	 editar	 toda	 a	informaçã o,	 para	 cada	 uma	 das	 várias	 STs	
consideradas	na	base	de	dados;
    *  ✔️
- Calcular	 o	 custo	 de	 uma	 viagem	 com	 determinada	 distância	 e	 numa	
determinada	 altitude	 tendo	 em	 conta	 a	 velocidade	 do	 vento	 para	 um	
determinado	avião.
    *  ✔️
    
## Requesitos para a segunda apresentação:

    Informações:
    §
    Cálculo de custo:
    o VCRUISE: velocidade de cruzeiro do avião (km/h)
    o VTAILWIND: velocidade do vento na cauda (>0 a favor e <0 contra) (km/h), deve-se
    assumir que por cada km/h afeta o consumo de combustível em +- 20l por cada
    1000km
    o AOPT: altitude de cruzeiro (em metros) do avião em que o seu consumo é o mais baixo
    o AFLIGHT: altitude efetiva a que se realizou o voo (m)
    o LPHOPT: consumo de combustível do avião em litros por hora. Exemplo: 8000 litros de
    fuel consumidos por cada hora de voo à altitude de cruzeiro. (l/h)
    o
    LPHEXTRA: consumo extra de combustível (por hora) quando a altitude do voo difere
    (para cima ou para baixo) relativamente a AOPT. Exemplo: 200 litros por cada 1000
    metros acima ou abaixo. (l/h)
    o FLIGHTDISTANCE: distancia (km) do voo
    o FLIGHTDURATION = FLIGHTDISTANCE / VCRUISE (em fração de hora)
    o FLIGHTCONSUMPTION = FLIGHTDURATION * (LPHOPT + (|AOPT - AFLIGHT| / 1000) *
    LPHEXTRA + VTAILWIND * 20)
    § Deve-se assumir que os aviões abastecem a custo 0 sempre que aterram.
    § Deve-se considerar a distância máxima que um avião consegue viajar sem abastecer.
    Requisitos:
    § Deverá ser possível verificar se o grafo de ligações entre aeroportos é conexo
    § Caminhos: ( Tendo em conta os aviões disponíveis no aeroporto de origem)
    o
    o
    o
    o
    §
    §
    Caminho mais curto entre o Aeroporto X e Y
    Caminho mais económico entre o Aeroporto X e Y
    Caminho mais direto entre o Aeroporto X e Y.
    Caminho mais rápido entre o Aeroporto X e Y
    Deverá ser possível selecionar vértices do grafo a serem evitados e aplicar-lhe os
    mesmos algoritmos ou funcionalidades descritas anteriormente;
    Deverá ser possível selecionar um subgrafo e aplicar-lhe os mesmos algoritmos ou
    funcionalidades descritas anteriormente; (Exemplo: Aeroportos Europeus)
    Universidade Fernando Pessoa - Engenharia Informática
    1 de 2§
    Deverá ser possível efetuar pesquisas com vários critérios, combinados por
    operadores booleanos (cf. and, or); por exemplo, pesquisar aeroportos na europa
    and com mais de 5 ligações aéreas disponíveis
    Anexos:
    De forma a permitir agilizar o processo de recolha de informação a utilizar no
    projeto, está disponível na plataforma um ficheiro que representa o mapa aéreo (Grafo),
    sendo que está estruturado da seguinte forma:
    num_pesos
    código_aeroporto;código_aeroporto;distancia;velocidade_vento;túnel_ aéreo;
    Cada linha representa um vértice do grafo e a sua lista de adjacências.
    Para a disciplina de Linguagens de Programação II, deverá ser criada uma interface gráfica
    para:
    § Visualizar o grafo de aeroportos e respetivas ligações aéreas bem como da árvore
    de aeroportos, distinguindo de alguma forma os tipos de nós
    § Gerir o grafo através da adição e remoção de nós/vértices e arcos/ramos bem como
    edição dos seus atributos
    § A manipulação e gestão de toda a informação e das respetivas pesquisas deverá ser
    também suportada pela interface gráfica
