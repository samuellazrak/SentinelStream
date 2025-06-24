# SentinelStream

**Real-time Transaction Monitoring & Rule Evaluation Engine**

SentinelStream is a modular, event-driven Java application that ingests real-time financial transactions from Kafka, evaluates them against dynamic business rules using Drools, and dispatches alerts based on custom logic. Designed for modern fintech and enterprise environments.

---

## ✅ Features

- **Kafka Integration** – High-throughput, low-latency ingestion of transaction data
- **Drools Rule Engine** – Modular, declarative rule definitions (`.drl`) for fraud and anomaly detection
- **REST API** – Manage rules, simulate transactions, and monitor alerts
- **Flexible Alert Dispatch** – Supports webhook, email, or log-based notifications
- **Pluggable Architecture** – Easily extended with Redis, PostgreSQL, Prometheus, and more

---

## 🧱 Architecture

```
                         +------------------+
 Transaction App  --->   |   Kafka Topic    |
                         +--------+---------+
                                  |
                                  v
                       +----------+----------+
                       | Kafka Consumer (SB) |
                       +----------+----------+
                                  |
                                  v
                          +-------+--------+
                          |  Drools Engine  |
                          +-------+--------+
                                  |
                                  v
                        +---------+---------+
                        |  Alert Dispatcher |
                        | (webhook/db/mail) |
                        +---------+---------+
                                  ^
                                  |
                   +--------------+--------------+
                   |    REST API - Spring Boot    |
                   | - Create/Update rules        |
                   | - Simulate/test transactions |
                   | - View active alerts         |
                   +-----------------------------+
```

---

## 🔧 Tech Stack

| Component      | Technology                     |
| -------------- | ------------------------------ |
| Language       | Java 21                        |
| Framework      | Spring Boot 3.3.13             |
| Messaging      | Apache Kafka                   |
| Rule Engine    | Drools (KIE API)               |
| API Layer      | Spring Web                     |
| Build Tool     | Maven                          |
| Containerization| Docker, Docker Compose        |
| Optional Tools | Prometheus, Redis, PostgreSQL  |

---

## 📂 Project Structure

```
SentinelStream/
├── src/
│   └── main/
│       ├── java/com/sentinelstream/
│       │   ├── api/              # REST API controllers
│       │   ├── config/           # Spring & Drools configs
│       │   ├── consumer/         # Kafka consumer logic
│       │   ├── rules/            # Business rules (.drl)
│       │   ├── service/          # Rule evaluation & alert logic
│       │   ├── model/            # DTOs and domain models
│       │   └── alerts/           # Alert dispatchers
│       └── resources/
│           ├── application.yml
│           └── application-docker.yml
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven 3.9+
- Docker & Docker Compose

### Quick Start (Dockerized)

```bash
git clone https://github.com/samuellazrak/SentinelStream.git
cd SentinelStream
./mvnw clean package -DskipTests
docker-compose up --build
```

- Kafka UI: [http://localhost:8080](http://localhost:8080)
- REST API: [http://localhost:8081](http://localhost:8081)

---

## 🧪 Sample Rule (`rules/FraudRule.drl`)

```java
rule "Flag Large Transactions"
when
    $tx: Transaction(amount > 10000)
then
    System.out.println("ALERT: Large transaction - " + $tx);
end
```

---

## 📦 Docker Notes

- Kafka initialized using the `kafka-init-topics` service via `message.json`
- Kafka exposed internally as `kafka0:29092`
- REST API runs on port `8081`
- Docker Compose includes Kafka UI, Schema Registry, and Kafka Connect

---

## 📈 Roadmap

- [ ] Rule versioning and rollback
- [ ] Alert throttling and deduplication
- [ ] Enhanced simulation interface
- [ ] Web-based rule editor
- [ ] Prometheus/Grafana monitoring dashboard

---

## 📄 License

MIT — see [`LICENSE`](./LICENSE) for full details.