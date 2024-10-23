const dataModalTarget = document.querySelectorAll('[data-modal-target]');
const dataCloseModal = document.querySelectorAll('[data-close-modal]');



dataModalTarget.forEach(button => {
    button.addEventListener('click', (e) => {
        e.preventDefault();
        const modal = document.getElementById(button.dataset.modalTarget);
        modal.classList.remove('hidden');
    });
});

dataCloseModal.forEach(button => {
    button.addEventListener('click', (e) => {
        e.preventDefault();
        const modal = document.getElementById(button.dataset.closeModal);
        modal.classList.add('hidden');
    });
});