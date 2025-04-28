# 📱 MvpHierarquiaApp

**MvpHierarquiaApp** é um aplicativo Android desenvolvido em **Kotlin** utilizando **Jetpack Compose** para a construção da interface de usuário.  
Este MVP (Produto Mínimo Viável) foi criado para demonstrar a estrutura e o fluxo básico de um **sistema hierárquico de usuários**.

---

## ✨ Funcionalidades implementadas

- Tela de **login** de usuário master.
- **Visualização** dos perfis subordinados (usuários abaixo na hierarquia).
- Exibição de informações básicas dos subordinados, como:
  - Nome
  - Data/hora do último acesso
- Simulação de **início de chat individual** com subordinados.
- Simulação de **visualização de localização em tempo real** dos subordinados.
- Restrições de navegação:
  - O usuário pode ver apenas informações dos subordinados (não vê superiores).

**Observação:**  
Todos os dados neste MVP são **mockados** (não há integração real com banco de dados ou serviços externos ainda).

---

## 🛠️ Tecnologias utilizadas

- **Kotlin**
- **Jetpack Compose** (UI moderna e declarativa)
- **Navigation Compose** (gerenciamento de navegação entre telas)
- **Material 3** (componentes atualizados de design)
- **ViewModel** (gestão de estado)

---

## 📋 Requisitos para rodar o projeto

- **Android Studio Giraffe** (ou versão mais recente)
- **Android SDK 33+** (mínimo Android 13)
- Emulador Android ou dispositivo físico com Android 13 ou superior

---

## ⚙️ Configurações do projeto

- **Minimum SDK:** 33
- **Target SDK:** 35
- **Compile SDK:** 35
- **Versão Java/Kotlin:** Java 11
- **Arquitetura adotada:** separação em camadas (Model, View, ViewModel, Navigation)

---

## 🔐 Usuário de acesso padrão

- **Usuário:** `master`
- **Senha:** `1234`

*(Credenciais fixas apenas para testes do MVP.)*

---

## 🚀 Próximos passos sugeridos

- Implementar sistema de autenticação real (ex.: Firebase Authentication).
- Persistir hierarquia e perfis de usuários em banco de dados (local ou cloud).
- Implementar sistema de chat real entre usuários.
- Integração com serviços de localização (GPS).
- Melhorar cadastro de usuários subordinados (definir permissões específicas).
- Criar painel administrativo para o usuário master.

---

## 📌 Observação final

Este MVP foi estruturado para **ser facilmente expandido**.  
A arquitetura e a organização do código já estão preparadas para futuras adições como:
- APIs externas
- Serviços em tempo real
- Persistência de dados
- Melhorias visuais

