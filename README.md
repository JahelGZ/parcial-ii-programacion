## Integrantes:

- Jahel Alejandro Gutierrez Enriquez

- Juan Sebastian Lasso Vidal

## Descripción

Esta practica implementa una simulación de batallas entre criaturas en Java. Su objetivo es practicar clases abstractas, herencia y polimorfismo.

La clase abstracta `Criatura` reúne los datos comunes de las criaturas: nombre, salud y fuerza. También define los métodos `atacar` y `defender`, que cada tipo de criatura implementa a su manera.

## Criaturas y habilidades

- **Dragón:** ataca con el doble de su fuerza. Si tiene escamas gruesas, recibe la mitad del daño.
- **Mago:** su hechizo de fuego aumenta el daño de su ataque; el hechizo de escudo reduce el daño recibido a la mitad.
- **Guerrero:** su espada aumenta el daño de su ataque; si usa un escudo, recibe la mitad del daño.

## Simulación

La clase `Main` crea las criaturas y simula batallas por turnos. Cada criatura ataca a la otra mientras ambas sigan vivas. Al terminar, se muestran el ganador y la salud restante.

## Pruebas unitarias

Las pruebas de `CriaturasTest` verifican los ataques y defensas especiales, el límite mínimo de salud, el estado de vida de una criatura y el resultado de una batalla.

Para ejecutar las pruebas con Maven:

```bash
mvn test
```
