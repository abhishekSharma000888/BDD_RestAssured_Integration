
# Step 1: Project Structure 
![](/Users/abhisheksharma/Downloads/SDETProjects/BDD_RestAssured_Integration/src/main/java/images/1.png)

# 📘 README: BDD REST Assured Framework (Progress Tracker)

## ✅ Current Progress (as of Today)

### ✅ 1. Framework Setup
- Maven + TestNG + Rest Assured + Cucumber integrated
- Directory structure established:
    - `utility` → Dynamic payload generator
    - `config` → Request/Response spec builders
    - `hooks` → Cucumber Hooks for logging/debug
    - `stepdefinitions` → Glue code for feature steps
    - `features` → Gherkin-based scenarios
    - `runner` → Single point TestNG runner

### ✅ 2. BDD Scenario Implemented
- `POST /booking` tested with:
    - Randomized payload
    - Request/Response validation
    - Status code & field assertions

### ✅ 3. Utilities and Reusability
- `BookingPayloadUtil.java` to generate random input data
- `RequestResponseSpecBuilder.java` to eliminate hardcoding
- Hooks added to enable smart logging

### ✅ 4. Logging
- Request/Response logs shown only on failure
- Enhanced visibility for debugging

---

## 📍 Future Enhancements (Planned)

| Feature                     | Status   | Notes |
|----------------------------|----------|-------|
| ✅ JSON Schema Validation   | Pending  | Validate response structure |
| 🔒 Bearer/Auth Token Setup | Pending  | Add support for secured APIs |
| 🔁 Retry Logic              | Pending  | Re-run failed API tests |
| 🌐 Multi-Environment Config | Pending  | Test across staging/prod/dev |
| 📊 Allure/Extent Reports    | Pending  | Rich test reporting |
| 🧪 Parallel Execution       | Pending  | Faster CI/CD integration |

---

### 🧠 Usage
To run Cucumber tests:
```bash
mvn clean test
```

To open HTML report:
```bash
Open `target/cucumber-reports/index.html`
```

---

✅ *This file will be updated after each REST Assured session.*

