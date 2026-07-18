"""Test YouTube transcript API."""
from youtube_transcript_api import YouTubeTranscriptApi

# Test with V-01 video from the course
transcript = YouTubeTranscriptApi.get_transcript('tELkj4CmvgY')
print(f"Transcript lines: {len(transcript)}")
print("First 3 lines:")
for t in transcript[:3]:
    print(f'  {t["text"]}')
print("youtube_transcript_api FUNCIONA!")
