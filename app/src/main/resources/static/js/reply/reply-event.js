const writeButton = document.querySelector("#write");
const replyContent = document.querySelector("#reply-content");

replyService.getList(1, postId, showList);

replyPaging.addEventListener("click", (e) => {
    e.preventDefault();
    if(e.target.tagName === "A") {
        globalThis.page = e.target.getAttribute("href");
        replyService.getList(globalThis.page, postId, showList);
    }
});

writeButton.addEventListener("click", async (e) => {
    await replyService.write({memberId: memberId, replyContent: replyContent.value, postId: postId});
    await replyService.getList(globalThis.page, postId, showList);
});












