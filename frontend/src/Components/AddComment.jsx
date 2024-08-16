import React, { useState } from 'react'
import urls from '../url.json';
const AddComment = (props) => {
    const postId=props.id;
    const [username,setUsername]=useState("");
    const [comment,setComment]=useState("");


    const HandleSubmit= async (e)=>{
        
        e.preventDefault();
         const commentBody={"username":username,"comment":comment,"rating":1};
         setComment("");
        setUsername("");
         
    try {
        const response = await fetch(urls.Analyser+'/addComment?id='+postId, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(commentBody),
        });
  
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
       
        console.log('Success:');
        
      } catch (error) {
        console.error('Error:', error);
      }
    }
    const handleUser =(e)=>{
        setUsername(e.target.value);
    }
    const handleComment=(e)=>{
        setComment(e.target.value);
    }
  return (
    <>
     <div className="container add-comment text-start">
        <span className='add-comment-heading'>Add comment</span>
        <div className='add-comment-username'><input type="text" placeholder='username' onChange={handleUser} value={username}/></div>
        <div className='add-comment-content'> <textarea onChange={handleComment} value={comment}></textarea> </div>
        <button className='button' onClick={HandleSubmit}>comment</button>
    </div>
    </>
  )
}

export default AddComment