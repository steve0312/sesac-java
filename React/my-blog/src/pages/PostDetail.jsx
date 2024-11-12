import React from 'react'
import { useParams } from 'react-router-dom'

export default function PostDetail() {
  const { postId } = useParams();

  return (
    <div>{postId}번째 게시글</div>
  )
}
