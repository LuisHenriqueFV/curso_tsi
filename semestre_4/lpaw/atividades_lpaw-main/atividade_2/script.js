window.onload = function() {
    const canvas = document.getElementById('gameCanvas');
    const ctx = canvas.getContext('2d');

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight - 100;

    const backgroundImage = new Image();
    backgroundImage.src = '../atividade_2/logo.png';

    backgroundImage.onload = function() {
        ctx.drawImage(backgroundImage, 0, 0, canvas.width, canvas.height);
    };

    document.getElementById('start-btn').addEventListener('click', function() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        initGame(); 
    });

    anime({
        targets: '#start-btn',
        scale: [0.5, 1],
        duration: 1000,
        easing: 'easeOutElastic',
        delay: 500
    });
};

function initGame() {
    const canvas = document.getElementById('gameCanvas');
    const ctx = canvas.getContext('2d');
    
    ctx.fillStyle = "#ff6b6b";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
}
