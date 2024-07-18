**- Teknologi Yang Digunakan**

_- Framework Spring Boot_

_- Database H2_

**- Cara Menjalankan**

_- Jalankan Spring Boot dengan perintah **"mvn spring-boot:run"**_

**- Cara Akses Database**

_- Akses Database H2 dengan **"http://localhost:8080/h2-console"** , atur JDBC URL dengan **"jdbc:h2:mem:testdb"** ,User Name **"sa"** ,Password **"password"**_

**- Cara Testing API**

_- Gunakan Postman atau sejenisnya_

_- Akses dengan method POST pada endpoint "http://localhost:8080/products/batch"_

_- Pilih pada bagian Body->formdata_

_- Masukkan Key **"request"**_

_- Masukkan Value berikut :_

_**{
 "productsToAdd": [
    {"name": "Baju", "category": "Pakaian", "price": 100000},
    {"name": "Celana", "category": "Pakaian", "price": 70000}
  ],
  "productsToUpdate": [
    {"id": 1, "name": "Topi", "category": "Aksesoris", "price": 50000},
    {"id": 2, "name": "Baju", "category": "Pakaian", "price": 200000}
  ],
  "productIdsToDelete": [1, 2]
}**_

_- Masukkan Content-Type **"application/json"**_

