import React from 'react'

const Comment = (props) => {
    const comment=props.comment;
  return (
    <>
    <div className="container comment text-start">
        <div className='comment-username'>{comment.username}</div>
        <div className='comment-content'>{comment.comment}
        </div>
    </div>
    </>
  )
}

export default Comment