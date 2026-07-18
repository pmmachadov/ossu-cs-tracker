"""Test YouTube transcript API - v2."""
from youtube_transcript_api import YouTubeTranscriptApi

api = YouTubeTranscriptApi()

# Test with V-01 video from the course (Spanish video)
result = api.fetch('tELkj4CmvgY', languages=['es', 'en'])
print(f"Transcript snippets: {len(result)}")
print("First 5 lines:")
for i, snippet in enumerate(result[:5]):
    print(f'  {snippet.text}')
print("youtube_transcript_api FUNCIONA!")
