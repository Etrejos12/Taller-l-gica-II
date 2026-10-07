# Operador Logístico

Aplicación de escritorio en Java (Swing) para registrar envíos y calcular su tarifa según el tipo de transporte, organizada con el patrón MVC.

## Estructura

```
src/
 ├── modelos/
 │    ├── TipoEnvio.java      (enum: TERRESTRE, AEREO, MARITIMO)
 │    ├── Envio.java          (clase abstracta)
 │    ├── Terrestre.java
 │    ├── Aereo.java
 │    └── Maritimo.java
 ├── servicios/
 │    └── EnvioServicio.java
 ├── controladores/
 │    └── EnvioControlador.java
 ├── vistas/
 │    └── EnvioVista.java
 ├── iconos/
 │    ├── AgregarEnvio.png
 │    └── QuitarEnvio.png
 └── Logistica.java           (clase principal, main)
```

## Tarifas

`tarifa = distancia × TARIFA_KM + peso × RECARGO_KG`

| Tipo      | TARIFA_KM | RECARGO_KG |
|-----------|-----------|------------|
| Terrestre | 1.500     | 2.000      |
| Aéreo     | 5.000     | 4.000      |
| Marítimo  | 800       | 1.000      |

## Compilar y ejecutar

Requiere JDK 10 o superior (se usa `var`).

```bash
javac -encoding UTF-8 -d bin $(find src -name "*.java")
cp -r src/iconos bin/
java -cp bin Logistica
```

En un IDE (NetBeans, IntelliJ, Eclipse, VS Code) basta con marcar `src` como carpeta de fuentes y ejecutar `Logistica`.
