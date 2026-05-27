const API = "http://localhost:8080";

async function criarUsuario() {
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    const usuario = {
        nome,
        email,
        senha
    };

    await fetch(`${API}/usuarios`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    });

    alert("Usuário criado!");
}

async function criarPostagem() {
    const texto = document.getElementById("textoPostagem").value;

    const postagem = {
        texto,
        usuario: {
            id: 1
        }
    };

    await fetch(`${API}/postagens`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(postagem)
    });

    document.getElementById("textoPostagem").value = "";

    carregarFeed();
}

async function curtirPostagem(postId) {
    const curtida = {
        usuario: {
            id: 1
        },
        postagem: {
            id: postId
        }
    };

    await fetch(`${API}/curtidas`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(curtida)
    });

    alert("Postagem curtida ❤️");
}

async function carregarFeed() {
    const resposta = await fetch(`${API}/postagens`);
    const postagens = await resposta.json();

    const feed = document.getElementById("feed");
    feed.innerHTML = "";

    postagens.forEach(post => {
        feed.innerHTML += `
            <div class="card post-card">
                <div class="card-body">
                    <h5>${post.usuario.nome}</h5>
                    <p>${post.texto}</p>

                    <button class="btn btn-outline-danger btn-sm"
                        onclick="curtirPostagem(${post.id})">
                        ❤️ Curtir
                    </button>
                </div>
            </div>
        `;
    });
}

carregarFeed();