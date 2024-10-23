const replyLayout = document.querySelector("#replies");
const replyPaging = document.querySelector("#paging");

const showList = ({replies, pagination}) => {
    console.log("showList");
    let text = ``;
    let pagingText = ``;

    replies.forEach((reply) => {
        text += `
            <div style="display: flex">
                <div>${reply.id}</div>
                <div>${reply.replyContent}</div>
                <div>${reply.memberName}</div>
                <div>${timeForToday(reply.createdDate)}</div>
            </div>
        `;
    });
    replyLayout.innerHTML = text;

    if(pagination.prev){
        pagingText += `
            <div><a href="${pagination.startPage - 1}">이전</a></div>
        `
    }
    for(let i=pagination.startPage; i<=pagination.endPage; i++){
        if(pagination.page === i){
            pagingText += `<div style="color: red">${i}</div>`
        }else{
            pagingText += `<div><a href="${i}">${i}</a></div>`
        }
    }

    if(pagination.next) {
        pagingText += `
            <div><a href="${pagination.endPage + 1}">다음</a></div>
        `
    }

    replyPaging.innerHTML = pagingText;
}

function timeForToday(datetime) {
    const today = new Date();
    const date = new Date(datetime);

    let gap = Math.floor((today.getTime() - date.getTime()) / 1000 / 60);

    if (gap < 1) {
        return "방금 전";
    }

    if (gap < 60) {
        return `${gap}분 전`;
    }

    gap = Math.floor(gap / 60);

    if (gap < 24) {
        return `${gap}시간 전`;
    }

    gap = Math.floor(gap / 24);

    if (gap < 31) {
        return `${gap}일 전`;
    }

    gap = Math.floor(gap / 31);

    if (gap < 12) {
        return `${gap}개월 전`;
    }

    gap = Math.floor(gap / 12);

    return `${gap}년 전`;
}