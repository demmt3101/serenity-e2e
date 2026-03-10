# 🚀 Sauce Serenity E2E - Beginner

## 📌 Descripción

Este branch contiene la solución del ejercicio **beginner** usando **SerenityBDD + Cucumber + Selenium + Gradle**.

El objetivo de este nivel es demostrar una automatización básica con:

- configuración inicial del proyecto
- uso de `build.gradle`
- uso de `serenity.conf`
- uso de `serenity.properties`
- escenario en archivo `.feature`
- consumo de datos desde JSON
- implementación de `PageObject`
- validaciones básicas sobre la página

## 🎯 Objetivo del ejercicio

Implementar una prueba sencilla que permita:

- abrir la página de **SauceDemo**
- validar el título de la página
- validar la visibilidad de elementos principales del login

## 🧩 Tecnologías usadas

- **Java 17** ☕
- **Gradle** 🛠️
- **SerenityBDD** 📊
- **Cucumber** 🥒
- **Selenium WebDriver** 🌐
- **JSON Simple** 📁
- **AssertJ** ✅

## 📝 Escenario implementado

### **Feature:** Validación básica de la página de inicio de sesión

### **Scenario:** Abrir SauceDemo y validar elementos principales

- abrir la página
- validar el título
- validar logo visible
- validar campo username visible
- validar campo password visible
- validar botón login visible

## 📄 Datos de prueba

Los datos se consumen desde un archivo JSON ubicado en:

`src/test/resources/testdata/beginnerData.json`

### Ejemplo

```json
{
  "url": "https://www.saucedemo.com/",
  "expectedTitle": "Swag Labs"
}
```
## 🏗️ PageObject implementado

Se implementó un `PageObject` llamado `LoginPage`, el cual contiene:

- apertura de la página
- lectura del título
- validación del logo
- validación del campo username
- validación del campo password
- validación del botón login

Esto permite mantener una estructura más limpia, reutilizable y alineada con buenas prácticas de automatización. ✅

## ▶️ Ejecución

Desde la raíz del proyecto:

```bash
gradlew clean test
```
## 📊 Reportería

El reporte de Serenity se genera en:

`target/site/serenity/index.html`

## ⚙️ Configuración

El proyecto utiliza los siguientes archivos principales de configuración:

- `build.gradle`
- `serenity.conf`
- `serenity.properties`

Estos archivos permiten definir dependencias, configuración de ejecución y comportamiento general de SerenityBDD.

## ✅ Qué demuestra este branch

- configuración básica del proyecto
- uso de SerenityBDD
- uso de Cucumber con escenarios `.feature`
- lectura de datos desde JSON
- implementación de `PageObject`
- validaciones básicas UI
- reportería automática con Serenity

## 👨‍💻 Resultado

Este branch representa el nivel **beginner** de la prueba técnica, enfocado en una automatización simple, clara y bien estructurada. 🎉