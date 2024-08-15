import React, { useState } from 'react'
import urls from '../url.json'
const AddPost = () => {
    const [username,setUsername]=useState("");
    const [description,setDescription]=useState("");
    const [imageUrl,setImageUrl]=useState("");
   

    const handleUsername =(e)=>{
        setUsername(e.target.value);
    }
    const handleDescription=(e)=>{
        setDescription(e.target.value);
    }
    const handleImageUrl=(e)=>{
        setImageUrl(e.target.value);
    }
    const handlePost= async (e)=>{
        e.preventDefault();
        const postBody={"username":username,"description":description,"image":imageUrl,"upVotes":0,"downVotes":0,"comments":[]};
        setDescription
        ("");
       setUsername("");
       setImageUrl("");
        
   try {
       const response = await fetch(urls.Blog+'/blogs/addBlog', {
         method: 'POST',
         headers: {
           'Content-Type': 'application/json',
         },
         body: JSON.stringify(postBody),
       });
 
       if (!response.ok) {
         throw new Error('Network response was not ok');
       }
      
       console.log('Success:');
       
     } catch (error) {
       console.error('Error:', error);
     }
    }
  return (
   <>
   <div className="container post-width p-3 border bg-white">
    <h5 className='text-start px-4'>Add a Post</h5>
   
    <div className="container d-flex flex-column text-start px-4">
        <span className='add-username'> <input type="text" value={username} onChange={handleUsername} placeholder='username'/></span>
    </div>
    <div className="container px-4 py-1">
        <h6 className='add-description text-start'><textarea spellCheck="false" onChange={handleDescription} placeholder='Write a caption...' value={description}></textarea></h6>
    </div>
    <div className="container px-4">
      { imageUrl===""? <p className='placeholder-text'>Add image address to the text input below </p> : <img src={imageUrl} className="img-fluid image-size" alt="" />}
    </div>
    
    <div className="container text-start px-4 py-1">
        
        <span className='add-image px-1'> <input type="text" value={imageUrl} onChange={handleImageUrl} placeholder='add image url'/></span>
        <button className='button' onClick={handlePost}>Post</button>
    </div>
    
    </div>

   </>
  )
}

export default AddPost