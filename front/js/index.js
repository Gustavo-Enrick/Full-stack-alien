function transformJSON(nome,email,senha){
    const form = {
        name: `${nome}`,
        email: `${email}`,
        password: `${senha}`,
    }
    const jsonForm = JSON.stringify(form);
    return jsonForm;
}

document.getElementById("submit").onclick = (event) => {
    event.preventDefault();
    const nome = document.getElementById("user").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("password").value;
    
    // Transformar os dados em JSON
    const jsonForm = transformJSON(nome, email, senha);

    const requestOptions = {
        headers: {
            "Accet": "application/json",
            "Content-Type": "application/json"
        },
        method: 'POST',
        body: jsonForm
    };
    
    // URL do endpoint
    const url = 'http://localhost:8081/cadastrar';

    // Fazendo a solicitação POST usando fetch
    fetch(url, requestOptions)
        .then(response => {
           return response;
        })
        .catch(error => {
            console.error('Erro:', error);
        });
};