# API do Sistema de Segurança Residencial com Sensores de Movimento

## 🔎 Sobre o Projeto

A **SecurityMonitor API** é responsável por receber alertas de sensores de movimento, armazená-los em um banco de dados PostgreSQL e notificar os moradores via Telegram quando uma atividade suspeita for detectada.

O sistema garante que qualquer movimento inesperado captado pelos sensores seja rapidamente informado aos residentes, permitindo uma resposta ágil a possíveis ameaças.

## 🦾 Funcionalidades

- Recebimento de alertas de sensores de movimento em tempo real
- Armazenamento dos alertas em um banco de dados PostgreSQL
- Integração com a API do Telegram para notificações instantâneas
- Notificação automática em um grupo de moradores no Telegram

## 🛠️ Arquitetura

A API é construída em **Java 17** e expõe um endpoint RESTful que recebe notificações dos sensores de movimento.

## 📍 Endpoint

### **POST /alert**

Recebe alertas dos sensores de movimento quando há detecção de atividade.

**Corpo da Requisição (JSON):**
```json
{
    "status": "DETECTED",
    "sensorIdentifier": "S01"
}
```

**Parâmetros:**
- `status`: Indica o status do sensor (DETECTED quando movimento é captado)
- `sensorIdentifier`: Identificador único do sensor que enviou o alerta

## ✅ Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- Banco de dados PostgreSQL
- Acesso à API do Telegram (Bot Token)

## 🔗 Integrações

### 📞 Telegram

A API se integra com o Telegram para enviar notificações de alertas. As mensagens são enviadas para:

- **Grupo de Moradores**: Todos os alertas são enviados para esse grupo, garantindo que os residentes estejam cientes de qualquer movimento suspeito.

### 🐘 PostgreSQL Local

A API utiliza um banco de dados PostgreSQL para armazenar informações relevantes. Estrutura do banco:

- **Sensores**: Contêm identificadores, localização e status dos sensores.
- **Alertas**: Armazena o timestamp do alerta e o sensor correspondente.

## ⚙️ Desenvolvimento

### 🗃️ Estrutura do Projeto

```
security-moitor-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── victordev/
│   │   │           └── security_moitor/
│   │   │               ├── config/
│   │   │               │   └── CorsConfig.java          // Configuração de CORS
│   │   │               ├── controller/
│   │   │               │   ├── AlertController.java     // Controlador para alertas de sensores
│   │   │               │   ├── SensorController.java    // Controlador para gerenciamento de sensores
│   │   │               ├── mappers/
│   │   │               │   ├── AlertMapper.java        // Mapeamento de DTOs para alertas
│   │   │               │   ├── SensorMapper.java       // Mapeamento de DTOs para sensores
│   │   │               ├── model/
│   │   │               │   ├── dto/
│   │   │               │   │   ├── alert/
│   │   │               │   │   │   ├── AlertRequestDTO.java
│   │   │               │   │   │   ├── AlertResponseDTO.java
│   │   │               │   │   ├── sensor/
│   │   │               │   │   │   ├── SensorRequestDTO.java
│   │   │               │   │   │   ├── SensorResponseDTO.java
│   │   │               │   ├── enums/
│   │   │               │   │   ├── AlertStatus.java     // Enum para status de alertas
│   │   │               │   │   ├── SensorStatus.java    // Enum para status de sensores
│   │   │               │   ├── Alert.java               // Entidade do alerta
│   │   │               │   ├── Sensor.java              // Entidade do sensor
│   │   │               ├── repository/
│   │   │               │   ├── AlertRepository.java     // Repositório de alertas
│   │   │               │   ├── SensorRepository.java    // Repositório de sensores
│   │   │               ├── service/
│   │   │               │   ├── exception/
│   │   │               │   ├── AlertService.java        // Serviço para alertas
│   │   │               │   ├── SensorService.java       // Serviço para sensores
│   │   │               │   ├── TelegramService.java     // Serviço de envio de alertas via Telegram
│   │   │               ├── SecurityMoitorApplication.java // Classe principal da aplicação
│   │   ├── resources/
│   │   │   ├── application.properties  // Configurações do banco e API do Telegram
│   ├── test/
│   ├── target/
└── pom.xml
```

## 🧑🏻 Autor

João Victor