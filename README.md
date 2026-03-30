# 🚀 Serenity E2E – SauceDemo (Beginner)

## 📌 Descripción

Este proyecto contiene una automatización **E2E (End‑to‑End)** implementada con  
**SerenityBDD + Cucumber + Selenium + Gradle**, utilizando **Screenplay Pattern directamente en los Step Definitions**.

El ejercicio corresponde al nivel **Beginner** y demuestra una base sólida de automatización, aplicando buenas prácticas sin sobre‑arquitectura.

---

## 🎯 Objetivo del ejercicio

Automatizar un flujo completo de compra en la aplicación **SauceDemo**, validando:

- acceso correcto al sistema
- visualización de la página de productos
- selección dinámica de productos
- flujo de checkout
- confirmación de orden exitosa

---

## 🧩 Tecnologías utilizadas

- **Java 17** ☕ (Java Toolchain)
- **Gradle** 🛠️
- **SerenityBDD 4**
- **Cucumber**
- **Selenium WebDriver**
- **Screenplay Pattern**
- **JUnit Platform**

---

## 🧠 Enfoque de automatización

La solución utiliza el **Screenplay Pattern**, aplicado directamente dentro de los **Step Definitions**, sin separar aún en:

- Tasks
- Questions
- PageObjects

Este enfoque fue elegido para:

- facilitar el aprendizaje inicial de Screenplay
- mantener el código simple y legible
- evitar sobre‑ingeniería en una prueba beginner

Los pasos expresan la **intención del usuario**, utilizando:

- `Actor`
- `BrowseTheWeb`
- `Open`
- `Enter`
- `Click`

---

## 📝 Escenario implementado

### Feature: Compra de productos en SauceDemo

### Scenario: Compra exitosa de dos productos aleatorios

El escenario cubre el siguiente flujo:

- el usuario abre la página de login
- ingresa credenciales válidas
- visualiza la página de productos
- selecciona **dos productos aleatorios**
- navega al carrito de compras
- inicia el proceso de checkout
- completa la información requerida
- finaliza la compra
- valida el mensaje de orden completada

---

## 🎲 Selección aleatoria de productos

La automatización selecciona **dos productos distintos de forma aleatoria**, asegurando que:

- no se repita el mismo producto
- cada ejecución pueda cubrir combinaciones diferentes

Esto se logra mezclando dinámicamente la lista de productos disponibles antes de agregarlos al carrito.

---

## ▶️ Ejecución del proyecto

Desde la raíz del proyecto:

```bash
./gradlew clean test
```

Al finalizar la ejecución, Gradle invoca automáticamente la generación del reporte Serenity mediante la tarea `aggregate`.

---

## 📊 Reportes

Serenity genera un reporte detallado de la ejecución que incluye:

- pasos ejecutados
- capturas de pantalla automáticas
- estado del escenario
- tiempos de ejecución

**Ruta del reporte:**

```
target/site/serenity/index.html
```

---

## ⚙️ Configuración del proyecto

Los archivos principales de configuración son:

- `build.gradle`
- `serenity.conf`
- `serenity.properties`
- `gradle-wrapper.properties`

Estos archivos definen:

- dependencias del proyecto
- uso de **Java 17 Toolchain**
- integración con **Cucumber y JUnit Platform**
- comportamiento general de **SerenityBDD**

---

## ✅ Qué demuestra este ejercicio

- configuración moderna de SerenityBDD con Gradle
- uso correcto de Java Toolchains
- integración Cucumber + Screenplay
- automatización de un flujo E2E real
- selección dinámica de datos
- ejecución estable y reproducible
- generación automática de reportes

---

## 🧪 Nivel del ejercicio

🟢 **Beginner**

Este nivel está enfocado en:

- comprender SerenityBDD
- introducir Screenplay Pattern
- construir una base antes de evolucionar a:
  - Tasks
  - Questions
  - PageObjects
  - manejo avanzado de datos

---

## 👨‍💻 Resultado

El proyecto representa una automatización E2E funcional, clara y extensible, preparada como base para niveles intermedios y avanzados.

✅ Ejecutable  
✅ Mantenible  
✅ Escalable  
✅ Alineada a buenas prácticas

---

## 🚀 Próximos pasos sugeridos

- migrar lógica a **Tasks & Questions**
- agregar datos dinámicos (Faker)
- paralelizar ejecución
- integrar CI/CD (GitHub Actions)
- crear el nivel **Intermediate**