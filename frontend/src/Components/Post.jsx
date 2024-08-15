import React, { useState } from 'react'
import Comment from './Comment'
import AddComment from './AddComment'
import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import ThumbDownIcon from '@mui/icons-material/ThumbDown';
const Post = (props) => {
  const blog=props.blog;


  
  return (<>
  <div className="container post-width p-3 border bg-white">
    <div className="container d-flex text-start px-4">
    <img src="https://cdn.vectorstock.com/i/500p/08/19/gray-photo-placeholder-icon-design-ui-vector-35850819.jpg" className="img-fluid profile-image-size" alt="" />
    <div className="container d-flex flex-column text-start ">
     
        <span className='username-size'>{blog.username}</span>
     
        <span className='id-size'>@{blog.id}</span>
    </div>
    </div>
    <div className="container px-4 py-1">
        <h6 className='description text-start'>{blog.description}</h6>
    </div>
    <div className="container px-4">
      <img src={blog.image} className="img-fluid image-size" alt="" />
    </div>
    <div className="container d-flex py-2 px-4 text-start">
      
        <span className='votes'>{blog.upVotes}</span>
      <ThumbUpIcon fontSize="small"/>
      <span className='votes'>{blog.downVotes}</span>
      <ThumbDownIcon fontSize="small"/>
     
    </div>
    <div className="container text-start px-4 "> 
      </div>
      <div className="container">
        <a 
          className='comments-heading d-flex px-4'
          data-bs-toggle="collapse" 
          href={'#'+blog.id} 
          role="button" 
          aria-expanded="false" 
          aria-controls="collapseComments">
          View all {blog.comments.length} Comments
        </a>
        <div className="collapse" id={blog.id}>
           {blog.comments.map((comment,index)=>(<Comment key={index} comment={comment}/>))}
           <AddComment id={blog.id}/>
  
        </div>
     
    </div>

  </div>
  </>
  )
}

export default Post