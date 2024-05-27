
      function displayTime() {
          var now = new Date();
          var hours = now.getHours().toString().padStart(2, '0');
          var minutes = now.getMinutes().toString().padStart(2, '0');
          var seconds = now.getSeconds().toString().padStart(2, '0');
          document.getElementById('time').textContent = hours + ':' + minutes + ':' + seconds;
      }
 
window.onload = function() {
    setInterval(displayTime, 1000);
};
function submit_onClick() {
    alert("提交成功");
}
function cancle_onClick() {
    alert("取消成功");
}
