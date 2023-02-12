const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", (event) => {
    console.log("add completely");

    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", (event) => {
    container.classList.remove("sign-up-mode");
    console.log("remove completely");
});
